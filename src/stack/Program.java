package stack;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack();
        //Stack 개체 생성

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        //스택에 정수를 push

        while (!stack.isEmpty()){
            int num = stack.remove(0);
            //remove() 메서드에 전달하는 인자는 무엇이든 상관없다.
            //오버라이딩한 remove() 메서드에서는 이를 전혀 사용하지 않기 때문
            System.out.println(num);
            //스택은 LIFO 자료구조니 제거되는 숫자의 순서는 5,4,3,2,1이 됨.

        }// 스택이 빌 때까지 pop

        System.out.println("-------------");

        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList가 하나 있다고 해봄.

        addInOrder(list,10);
        addInOrder(list,2);
        addInOrder(list,5);
        //addInOrder()를 사용해서 리스트에 정수들을 몇 개 추가함.


        for(int num : list) {
            System.out.println(num);
        }
        // 리스트에 들어가는 각 요소들을 출력해서 addInOder()가 제대로 작동했는지 확인할 수 있다.
        //2,5,10이 출력됨. addInOrder()가 제대로 작동함.

        System.out.println("--------------------");

        list = new Stack<>();
        //이제 스택을 list에 대입.

        addInOrder(list,10);
        addInOrder(list,2);
        addInOrder(list,5);
        //변수의 형은 ArrayList이긴 하지만 실제 개체의 자료형은 Stack이기 때문에 오름차순으로 돌아가지 않음.
        //그리고 Stack의 add() 메서드는 새로운 정수를 언제나 리스트의 제일 마지막에 추가한다.
        
        for(int num : list) {
            System.out.println(num);
        }// 해당 리스트를 순회하면서 숫자들을 출력해보면 10,2,5이다.
        //이건 리스트에 숫자를 추가한 순서와 동일
    }   //상속을 사용해서 Stack과 ArrayList 간의 관계를 is-a 관계로 만들었음.
        //스택 데이터 구조의 가장 중요한 규칙인 후입선출을 어기는 것이다.
        //따라서 ArrayList로 부터 Stack Class를 구현하는 올바른 방법은 사옥이 아니라 컴포지션을 사용하는 것
    private static void addInOrder(ArrayList<Integer> list, int num){
        //addInOrder() 메서드 생성, 해당 메서드는 리스트 안에 오름차순으로 정수를 추가
        //Stack은 ArrayList가 아니다! 따라서 ArrayList 같은 것을 상속해서 구현하면 안 됨.

        int i;

        for(i=0;i<list.size(); ++i){
            if(list.get(i)>num){
                break;
            }
        } //오름차순으로 설정
        list.add(i,num);
    }
}
