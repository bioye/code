class ArrayStack<T>{

  int capacity = 4;
  T[]items;
  int size=0;

  ArrayStack(){
    items = (T[])new Object[capacity];
  }

  public String toString(){
    StringBuilder stringStack = new StringBuilder();
    for(int i=0;i<size; i++){
      stringStack.append(items[i]+", ");
    }
    return stringStack.toString();
  }

  T pop() throws Exception{
    if(size==0){
      throw new Exception("Stack is empty");
    }
    T item = items[size-1];
    size--;
    return item;
  }

  void push(T item){
    //first item
    if(size==0){
      items[0]=item;
    }
    //successive
    else{
      items[size]=item;
    }
    size++;
    if(size==capacity){
      capacity*=size;
      //arraycopy
    items = arrayCopy(items, (T[])new Object[capacity]);
    }
  }

  T peek() throws Exception{
    if(size==0){
      throw new Exception("Stack is empty");
    }
    return items[size-1];
  }

  boolean isEmpty(){
    return size==0;
  }

  T[] arrayCopy(T[]from, T[]to){
    for(int i=0; i<from.length;i++){
      to[i]=from[i];
    }
    return to;
  }

  public static void main(String[] args) throws Exception{
    ArrayStack<Integer> stack = new ArrayStack<>();
    System.out.println("Initial: " + stack);
    stack.push(1);
    System.out.println("Pushed 1: " + stack);
    stack.push(2);
    System.out.println("Pushed 2: " + stack);
    stack.push(3);
    System.out.println("Pushed 3: " + stack);
    stack.push(4);
    System.out.println("Pushed 4: " + stack);
    stack.pop();
    System.out.println("Popped: " + stack);
    stack.pop();
    System.out.println("Popped: " + stack);
    stack.push(33);
    System.out.println("Pushed 33: " + stack);
    stack.push(33);
    System.out.println("Pushed 433: " + stack);
    stack.push(44);
    System.out.println("Pushed 44: " + stack);
    stack.pop();
    System.out.println("Popped: " + stack);
  }
}
