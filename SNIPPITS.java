//////////////////////////////////////////
/////ANNOTATIONS PLUGIN SYS///////////////
//////////////////////////////////////////


String packages="";

ArrayList<String>losFioles=new ArrayList<String>();

public void rcDir(String d){

    for(File file:new File(d).listFiles()){
        if(file.isDirectory()){
            rcDir(file.getAbsolutePath());
            continue;
        }else{
            losFioles.add(file.getAbsolutePath().replace(packages,"").replace(".class","").replace('\\','.'));
        }
    }


}


        try{
        Class cls=Class.forName("anotttest.TestPlugin");
//            System.out.println("WIN: " + Arrays.toString(cls.getDeclaredAnnotations()));
        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }


        for(String classpathEntry:System.getProperty("java.class.path").split(System.getProperty("path.separator"))){
//            System.out.println("ce: " + classpathEntry);
        if(classpathEntry.startsWith("C:\\Users\\Freedman\\GameWorkspaces\\SpaceShooterD4")){
        //System.err.println(classpathEntry);
        System.err.println("CPE: "+classpathEntry);
        packages=classpathEntry+"\\";
        rcDir(classpathEntry);
        }
        if(classpathEntry.endsWith(".jsar")){
        File jar=new File(classpathEntry);

        JarInputStream is=null;
        try{
        is=new JarInputStream(new FileInputStream(jar));
        }catch(IOException e){
        e.printStackTrace();
        }

        JarEntry entry;
        try{
        while((entry=is.getNextJarEntry())!=null){
        if(entry.getName().endsWith(".class")){
        // Class.forName(entry.getName()) and check
        //   for implementation of the interface
        }
        }
        }catch(IOException e){
        e.printStackTrace();
        }
        }
        }


        for(String s:losFioles){
        System.out.println("FIOLE: "+s);
        try{
        Class cls=Class.forName(s);
        System.out.println("WIN: "+Arrays.toString(cls.getDeclaredAnnotations()));
//                System.out.println("pls" + ((PluginSys)cls.getDeclaredAnnotation(PluginSys.class)).name());
        if(cls.getDeclaredAnnotation(PluginSys.class)!=null){
        System.err.println("Instancing");
        cls.newInstance();
        }
        }catch(ClassNotFoundException e){
        System.out.println(e.getMessage());
        }catch(InstantiationException e){
        e.printStackTrace();
        }catch(IllegalAccessException e){
        e.printStackTrace();
        }

        }


///////////////////////////////////////////
//////START CLIENT CONNECTION CODE/////////
///////////////////////////////////////////

try{
        String serverHostname=new String("127.0.0.1");

        System.out.println("Attemping to connect to host "+
        serverHostname+" on port 7683.");

        Socket echoSocket=null;
        ObjectOutputStream out=null;
        ObjectInputStream in=null;

        try{
        echoSocket=new Socket(serverHostname,7683);
        out=new ObjectOutputStream(echoSocket.getOutputStream());
        in=new ObjectInputStream(echoSocket.getInputStream());
        }catch(UnknownHostException e){
        System.err.println("Don't know about host: "+serverHostname);
        }catch(IOException e){
        System.err.println("Couldn't get I/O for "
        +"the connection to: "+serverHostname);
        }

        BufferedReader stdIn=new BufferedReader(
        new InputStreamReader(System.in));
        String userInput;

        System.out.println("Type Message (\"Bye.\" to quit)");
        while((userInput=stdIn.readLine())!=null){
        Packet packet=new SimpleTextPacket(userInput);
        out.writeObject(packet);

        // end loop
        if(userInput.equals("Bye."))
        break;

        Packet packet1=(Packet)in.readObject();
        if(packet1.getPacketId()==1){
        System.out.println("echo: "+((SimpleTextPacket)packet1).getUserInput());
        }else{
        System.err.println(packet1.getPacketId());
        }
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();

        }catch(Exception e){
        e.printStackTrace();
        }

///////////////////////////////////////////
///////END CLIENT CONNECTION CODE//////////
///////////////////////////////////////////