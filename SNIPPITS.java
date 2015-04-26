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