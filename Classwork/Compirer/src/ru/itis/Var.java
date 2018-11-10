package ru.itis;

public class Var {
    public String stringValue;
    public String name;
    public int value;

    public Var(String value) {
        String[] valueArray = value.split(":=");
        name = valueArray[0];
        stringValue = valueArray[1];
    }


    public int findValue(ArrayList arrayList) {
        try {
            return value = Integer.parseInt(stringValue);
        } catch (Exception e) {
            boolean isFoundFirst = false;
            for (int j = 0; j < arrayList.size(); j++) {
                Var varJ = (Var) arrayList.get(j);
                if (varJ.name.equals(stringValue.substring(0, 2))) {
                    value = varJ.findValue(arrayList);
                    isFoundFirst = true;
                }
            }
            if (!isFoundFirst) throw new IllegalArgumentException();
            try {
                int secondValue = 0;
                for (int j = 0; j < arrayList.size(); j++) {
                    Var varJ = (Var) arrayList.get(j);
                    if (varJ.name.equals(stringValue.substring(3, 5))) {
                        secondValue = varJ.findValue(arrayList);
                    }
                }
                switch (stringValue.charAt(2)) {
                    case '+':
                        value += secondValue;
                        break;
                    case '*':
                        value *= secondValue;

                        break;
                    case '-':
                        value *= secondValue;

                        break;
                    case '/':
                        value *= secondValue;
                        break;
                }

            } catch (ArrayIndexOutOfBoundsException k) {
            }
            return value;
        }
    }
}
