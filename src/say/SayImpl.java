package say;

import java.util.HashMap;

public class  SayImpl implements Say {

    private Status status = Status.START;
    HashMap<Words,String> person = new HashMap<>();

    public SayImpl(){

    }

    @Override
    public Words pick(String userName, Words word) throws StatusException {

        Words takenWord = null;
        takenWord = this.getTakenWord(userName,word);

        return null;
    }

    private Words getTakenWord(String userName, Words word) {
        String name = this.person.get(word);
        return null;
    }

    @Override
    public boolean say(Words word) throws StatusException {
        System.out.println(person.get(word)+"says hello!");
        return true;
    }
}
