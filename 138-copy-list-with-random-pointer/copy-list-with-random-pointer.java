/**
trick: The main part is to handle the random connection, for that we maintain a map for oldNode and newNode.
When creating a new node we check if the curr oldNode is already present in the map else we create a new one.

We add it to the map. 

if the random is null we assign null
If the random is alrdy present in the map (random assigned for a left side), we get it from the map and assign it.
if the random is not present (random is on the right), we create a copy of the curr.random and assing it to our newCur. Later we add the tmp node to the map as well.

Time: O(n)
Space: O(n)
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();  //oldNode, newNode

        Node dummy = new Node(-1);
        Node newCur;
        Node prev = dummy;

        Node curr = head;

        while(curr != null){

            newCur = map.getOrDefault(curr, new Node(curr.val));
            
            map.put(curr, newCur);

            if(curr.random == null){
                newCur.random = null;
            } else if(map.containsKey(curr.random)){
                Node tmp = map.get(curr.random);
                newCur.random = tmp;
            } else {
                Node tmp = new Node(curr.random.val);
                newCur.random = tmp;
                map.put(curr.random, tmp);
            }

            prev.next = newCur;
            prev = newCur;

            curr = curr.next;
        }

        return dummy.next;
        
    }
}