import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteMap; // Stores votes (Candidate -> Votes)
    private LinkedHashMap<String, Integer> voteOrderMap; // Maintains order of votes
    
    public VotingSystem() {
        voteMap = new HashMap<>();
        voteOrderMap = new LinkedHashMap<>();
    }
    
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteMap.get(candidate));
    }
    
    public void displayResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteMap);
        System.out.println("Voting Results in Sorted Order:");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    public void displayVoteOrder() {
        System.out.println("Votes in the order they were cast:");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        
        votingSystem.displayResults();
        System.out.println();
        votingSystem.displayVoteOrder();
    }
}

