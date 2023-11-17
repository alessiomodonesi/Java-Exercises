public class ArrayAlgs {
    public static int[] resize(int[] oldArray, int newLength) {
        if (newLength < 0 || oldArray == null)
            throw new IllegalArgumentException();
        int[] newArray = new int[newLength];
        int n = oldArray.length;
        if (newLength < n)
            n = newLength;
        for (int i = 0; i < n; i++)
            newArray[i] = oldArray[i];
        return newArray;
    }
}