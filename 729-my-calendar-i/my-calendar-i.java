class MyCalendar {

    List<int[]> events;

    public MyCalendar() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        if(end < start ) return false;
        int[] newEvent = new int[2];
        newEvent[0] = start;
        newEvent[1] = end;

        for(int[] event : events){
            if(eventOverlap(event, newEvent)){
                return false;
            }
        }

        events.add(newEvent);
        return true;
    }

    private boolean eventOverlap(int[] event, int[] newEvent) {
        return event[1] > newEvent[0] && newEvent[1] > event[0];
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */