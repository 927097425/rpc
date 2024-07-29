package Train.Middian.Problem1;

public class Prisoner {
    private int code_number;
    private String name;
    private int pos;//记录一开始站的位置
    public int getCode_number() {
        return code_number;
    }

    public void setCode_number(int code_number) {
        this.code_number = code_number;
    }
    @Override
    public String toString(){
        return "{Prisoner: "+getName()+"  Position: "+getPos()+"   code:"+getCode_number()+"}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
