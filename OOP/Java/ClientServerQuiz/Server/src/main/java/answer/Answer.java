package answer;

import java.io.Serializable;

public class Answer implements Serializable {
    private String nick;
    private String answer;

    public Answer(String nick, String answer) {
        this.nick = nick;
        this.answer = answer;
    }

    public String getNick() {
        return nick;
    }

    public String getAnswer() {
        return answer;
    }
}

