package com.murodjon_sattorov.mantiqiysavol_javoblar;

public class Questions {
    private int img;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String ANSWER;

    public Questions(int img, String answer1, String answer2, String answer3, String answer4, String ANSWER) {
        this.img = img;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.ANSWER = ANSWER;
    }

    public int getImg() {
        return img;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getANSWER() {
        return ANSWER;
    }
}
