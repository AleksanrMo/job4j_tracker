package ru.job4j.collaction;
import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int cells) {
        int group = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[group][cells];
        int row = 0,  cell = 0;
        for (Integer in: list) {
            array[row][cell] = in;
            cell++;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row: rsl) {
            for (int cell: row) {
                System.out.println(cell + " ");
            }
            System.out.println();
        }
    }
}
