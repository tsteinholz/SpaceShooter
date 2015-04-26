package org.southriverhi.space.DNASharp;

import org.southriverhi.space.DNASharp.instruction.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Interpreter {

    private final Context context;

    public static void main(String[] args) throws IOException {
        String gattaca = "gattaca.txt";
        new File(gattaca).createNewFile();
        try {
            FileReader in = new FileReader(new File(gattaca));
            Interpreter interpreter = new Interpreter(in);
            interpreter.interpret();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + new File(gattaca).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Problem reading file: " + new File(gattaca).getAbsolutePath());
            e.printStackTrace(System.err);
        }
    }

    public Interpreter(Reader in) throws IOException {
        this(in, System.in, System.out);
    }

    public Interpreter(Reader programIn, InputStream in, OutputStream out) throws IOException {
        Instruction[] program = parseProgram(programIn);
        this.context = new Context(program, in, out);
    }

    public void interpret() {
        try {
            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (!context.isTerminated()) {
                //in.readLine();
                context.fetchAndExecute();
            }
        } catch (Exception e) {
            System.err.println("IO problem executing instruction " + context.getInstructionPointer());
            e.printStackTrace(System.err);
        }
    }

    private Instruction[] parseProgram(Reader in) throws IOException {
        List<Instruction> program = new ArrayList<Instruction>();
        int token;
        Instruction instruction;
        String temp = "";
        while ((token = in.read()) != -1) {
            if(token == 32 || token == 45 || token == 13 || token == 10) continue;
            temp += (char)token;
            //System.out.println("Added instruction: " + instruction);
        }

        List<String> cmds = getParts(temp, 4);
        for(String s : cmds){
            switch (s) {
                case "ATAT":
                    instruction = new IncDataPointer();
                    break;
                case "ATGC":
                    instruction = new DecDataPointer();
                    break;
                case "ATTA":
                    instruction = new IncData();
                    break;
                case "ATCG":
                    instruction = new DecData();
                    break;
                case "GCAT":
                    instruction = new Output();
                    break;
                case "GCGC":
                    instruction = new Input();
                    break;
                case "GCTA":
                    instruction = new CondJump(true);
                    break;
                case "GCCG":
                    instruction = new CondJump(false);
                    break;
                default:
                    // Other symbols are ignored
                    instruction = null;
            }
            if (instruction != null) {
                program.add(instruction);
            }
//            System.out.println("added instruction: " + instruction.toString());

        }

//        System.out.println(Arrays.toString(program.toArray()));

        return program.toArray(new Instruction[]{});
    }

    private static List<String> getParts(String string, int partitionSize) {
        System.out.println("STR: " + string);
        List<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i = 0; i < len; i += partitionSize) {
            parts.add(string.substring(i, Math.min(len, i + partitionSize)));
            System.out.println(string.substring(i, Math.min(len, i + partitionSize)));
        }
//        System.out.println("PARTSDPME");

        return parts;
    }

}