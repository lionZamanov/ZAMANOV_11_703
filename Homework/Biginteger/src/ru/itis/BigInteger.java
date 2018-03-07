package ru.itis;

public class BigInteger {
    private String number;
    private byte[] ArrayNumber;

    public BigInteger() {
        this("0");
    }

    public BigInteger(String number) {
        this.number = number;
        ArrayNumber = stringToArray(number);
    }

    public void setNumber(String number) {
        this.number = number;
        ArrayNumber = stringToArray(number);
    }

    public void setArrayNumber(byte[] arrayNumber) {
        number = arrayToString(deleteNulls(arrayNumber));
        ArrayNumber = deleteNulls(arrayNumber);
    }

    public byte[] getArrayNumber() {
        return ArrayNumber;
    }

    public String getNumber() {
        return number;
    }

    public static byte[] stringToArray(String number) {
        byte[] array = new byte[number.length()];
        for (int i = 0; i < number.length(); i++) {
            array[i] = (byte) Character.getNumericValue(number.charAt(i));
        }
        return array;
    }

    public static String arrayToString(byte[] array) {
        String result = "";
        int i = 0;
        for (int j = i; j < array.length; j++) {
            result += array[j];
        }
        return result;
    }

    public void sum(String secondNumber) {
        BigInteger bi = new BigInteger(secondNumber);
        sum(bi);
    }

    public BigInteger sum(BigInteger secondNumber) {
        BigInteger[] arrayOfBigInteger = new BigInteger[2];
        if (secondNumber.number.length() > this.number.length()) {
            arrayOfBigInteger[0] = secondNumber;
            arrayOfBigInteger[1] = this;
        } else {
            arrayOfBigInteger[0] = this;
            arrayOfBigInteger[1] = secondNumber;
        }

        int zero = arrayOfBigInteger[0].number.length();
        int first = arrayOfBigInteger[1].number.length();
        byte[] resultArray = new byte[zero + 1];

        while (first > 0) {
            resultArray[zero] += arrayOfBigInteger[0].ArrayNumber[zero - 1] + arrayOfBigInteger[1].ArrayNumber[first - 1];
            if (resultArray[zero] >= 10) {
                resultArray[zero - 1]++;
                resultArray[zero] %= 10;
            }
            zero--;
            first--;
        }
        while (zero > 0) {
            resultArray[zero] += arrayOfBigInteger[0].ArrayNumber[zero - 1];
            zero--;
        }

        BigInteger result = new BigInteger();
        result.setArrayNumber(resultArray);
        return result;
    }

    public String deleteNulls(String StringNumber) {
        if (StringNumber.charAt(0) == 0) {
            if (StringNumber.length() != 1) {
                int i = 0,
                        k = 0;
                String resultString = "";
                while (StringNumber.charAt(i) == 0) i++;
                for (int j = i; j < StringNumber.length(); j++) {
                    resultString += getNumber().charAt(j);
                }
                return resultString;
            }
        }
        return StringNumber;
    }

    public byte[] deleteNulls(byte[] ArrayNumber) {
        int i = 0;
        while (ArrayNumber[i] == 0 && i < (ArrayNumber.length - 1)) i++;
        if (i != 0) {
            if (ArrayNumber.length != 1) {
                int k = 0;
                byte[] resultArray = new byte[ArrayNumber.length - i];
                for (int j = i; j < ArrayNumber.length; j++) {
                    resultArray[k] = ArrayNumber[j];
                    k++;
                }
                return resultArray;
            }
            byte[] k = {0};
            return k;
        }
        return ArrayNumber;
    }

    @Override
    public String toString() {
        return this.number;
    }

    public BigInteger multiple(BigInteger secondNumber) {
        BigInteger[] arrayOfBigInteger = new BigInteger[2];
        if (secondNumber.number.length() > this.number.length()) {
            arrayOfBigInteger[0] = secondNumber;
            arrayOfBigInteger[1] = this;
        } else {
            arrayOfBigInteger[0] = this;
            arrayOfBigInteger[1] = secondNumber;
        }
        int z = arrayOfBigInteger[0].number.length();
        int f = arrayOfBigInteger[1].ArrayNumber.length;
        BigInteger[] array = new BigInteger[f];
        int k = 0;
        for (int i = f; i > 0; i--) {
            byte[] byteMultiple = new byte[z + 1 + k];
            BigInteger bigInteger = new BigInteger();
            for (int j = z; j > 0; j--) {
                byteMultiple[j] += arrayOfBigInteger[1].ArrayNumber[i - 1] * arrayOfBigInteger[0].ArrayNumber[j - 1];
                if (byteMultiple[j] >= 10) {
                    byteMultiple[j - 1] += byteMultiple[j] / 10;
                    byteMultiple[j] %= 10;
                }
            }
            bigInteger.setArrayNumber(byteMultiple);

            array[i - 1] = bigInteger;
            k++;
        }
        BigInteger result = new BigInteger();

        for (int i = 0; i < array.length; i++) {
            result = result.sum(array[i]);
        }
        return result;
    }

}
//13613616138597685763
//25235264
//00005552775
