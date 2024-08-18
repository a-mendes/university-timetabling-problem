package pthu.entities.enums;

public enum ShiftEnum {
    MORNING(0), 
    AFTERNOON(1), 
    NIGHT(2);

    private final int code;

    ShiftEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ShiftEnum fromCode(int code) {
        for (ShiftEnum shift : ShiftEnum.values()) {
            if (shift.getCode() == code) {
                return shift;
            }
        }
        throw new IllegalArgumentException("Invalid code for ShiftEnum: " + code);
    }
}
