package Prog_여행경로;

import java.util.*;

class Ticket{
    String start;
    String end;
    boolean visited;
}
class Solution {
    public List<String> solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();

        for(int i = 0 ; i < tickets.length; i++){
            for(int j = 0; j < tickets[0].length;j++){
                Ticket ticket = new Ticket();
                ticket.start = tickets[i][0];
                ticket.end = tickets[i][1];
                ticket.visited = false;

                ticketList.add(ticket);
            }
        }

        ticketList.sort(Comparator.comparing(t -> t.end));

        Queue<Ticket> q = new LinkedList<>();

        ticketList.get(0).visited = true;
        q.add(ticketList.get(0));
        answer.add(tickets[0][0]);
        answer.add(tickets[0][1]);
        while(!q.isEmpty()){

            Ticket currentTicket = q.poll();

            for(Ticket t : ticketList){
                if(currentTicket.end.equals(t.start) && t.visited == false){
                    q.add(t);
                    t.visited = true;
                    answer.add(t.start);
                    break;
                }
            }

        }

        return answer;
    }
}