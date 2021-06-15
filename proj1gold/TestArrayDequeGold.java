import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void Test1(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            int keyofoperation = StdRandom.uniform(4);
            int keyofelement = StdRandom.uniform(10);

            if(sad1.isEmpty()){
                keyofoperation = keyofoperation/2;//0,1 used for adding
            }

            switch (keyofoperation){
                case 0:
                    sad1.addFirst(keyofelement);
                    ads1.addFirst(keyofelement);
                    sb.append(String.format("addFirst(%d) \n",keyofelement));
                    break;
                case 1:
                    sad1.addLast(keyofelement);
                    ads1.addLast(keyofelement);
                    sb.append(String.format("addLast(%d) \n",keyofelement));
                    break;
                case 2:
                    sb.append("removeFirst() \n");
                    assertEquals(sb.toString(),ads1.removeFirst(),sad1.removeFirst());
                    break;
                case 3:
                    sb.append("removeLast() \n");
                    assertEquals(sb.toString(),ads1.removeLast(),sad1.removeLast());
                    break;

            }

        }


    }
}
