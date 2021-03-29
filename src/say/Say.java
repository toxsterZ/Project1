package say;

public interface Say {



    Words pick(String person, Words word) throws StatusException;

    boolean say(Words word) throws StatusException;
}
