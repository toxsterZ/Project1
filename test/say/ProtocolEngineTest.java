package say;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ProtocolEngineTest {
    public static final String PERSON = "Max";
    public static final int PORTNUMBER = 8049;
    private static int port = 0;
    public static final long TEST_THREAD_SLEEP_DURATION = 1000;

    private Say getTTTEngine(InputStream is, OutputStream os, Say engine) throws IOException {
        TicTacToeTCPProtocolEngine ticTacToeTCPProtocolEngine = new TicTacToeTCPProtocolEngine(gameEngine);
        ticTacToeTCPProtocolEngine.handleConnection(is, os);
        return ticTacToeTCPProtocolEngine;
    }
}
