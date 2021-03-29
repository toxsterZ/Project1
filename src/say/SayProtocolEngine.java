package say;

import java.io.*;

public class SayProtocolEngine implements Say {
    private final OutputStream os;
    private final InputStream is;
    private final Say engine;
    public static final int METHOD_PICK = 0;
    public static final int METHOD_SAY = 1;


    public SayProtocolEngine(InputStream is, OutputStream os, Say engine) {
        this.is = is;
        this.os = os;
        this.engine = engine;
    }

    @Override
    public Words pick(String person, Words word) throws StatusException {
        DataOutputStream dos = new DataOutputStream(this.os);

        try {
            dos.writeInt(METHOD_PICK);

            dos.writeUTF(person);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void deserialiePick() throws Exception {
        DataInputStream dis = new DataInputStream(this.is);
        Words word = Words.Hello;
        String person = dis.readUTF();
        this.engine.pick(person, word);
    }

    @Override
    public boolean say(Words word) throws StatusException {
        DataOutputStream dos = new DataOutputStream(this.os);

        try {
            dos.writeInt(METHOD_PICK);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void deserialieSay() throws Exception {
        DataInputStream dis = new DataInputStream(this.is);
        Words word = Words.Hello;
        String person = dis.readUTF();
        this.engine.say(word);
    }

    public void read() {
        DataInputStream dis = new DataInputStream(this.is);

        try {
            int commandID = dis.readInt();
            switch (commandID) {
                case METHOD_PICK:
                    this.deserialiePick();
                    break;
                case METHOD_SAY:
                    this.deserialieSay();
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}