class MyCalendar {

    class Node{
        int start, end;
        Node left, right;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    public MyCalendar() { 
        root = null;
    }
    
    public boolean book(int start, int end) {
        if(root == null){
            Node node = new Node(start, end);
            root = node;
            return true;
        }

        return insert(root, start, end);
    }

    private boolean insert(Node root, int start, int end){

        if(end <= root.start){
            if(root.left == null){
                Node node = new Node(start, end);
                root.left = node;
                return true;
            } else return insert(root.left, start, end);
        }

        if(start >= root.end){
            if(root.right == null){
                Node node = new Node(start, end);
                root.right = node;
                return true;
            } else return insert(root.right, start, end);
        }

        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */