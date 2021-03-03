package stack;

import java.util.ArrayList;

public final class Stack<E> extends ArrayList<E> {
    //ArrayList를 확장해서 구현 할 것임
    //스택 자료구조의 일반적인 메서드는 push()와 pop

    @Override
    public void add(int index, E element) {
        super.add(element);
    }
    //ArrayList()의 add() 메서드 중 하나를 오버라이딩하여 리스트의 중간에
    //요소를 더하지 못하게 만듦, 그러면 add()는 push와 동일하게 작동

    @Override
    public E remove(int index) {
        assert this.size() > 0;

        int lastIndex = size() - 1;
        E element = get(lastIndex);

        super.remove(lastIndex);

        return element;
    }
    //마찬가지로 ArrayList의 remove() 메서드들을 오버라이딩하여 리스트의 마지막 요소만 제거 할 수 있게 만듦.
    //그럼 remove()가 pop()과 동일하게 작동


    @Override
    public boolean remove(Object o) {
        if (this.size() == 0) {
            return false;
        }

        remove(0);

        return true;
    }
    //remove() 메서드가 2개 있으니 둘 다 오버라이딩함

}
