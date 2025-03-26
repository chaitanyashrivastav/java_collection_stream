import java.util.*;
import java.time.*;

// Insurance Policy Class
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy[Number=" + policyNumber + ", Holder=" + policyholderName + ", Expiry=" + expiryDate + ", Type=" + coverageType + ", Premium=$" + premiumAmount + "]";
    }
}

public class InsurancePolicyManagement {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();

    // Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Display all policies
    public void displayPolicies(Set<Policy> policies) {
        for (Policy policy : policies) {
            System.out.println(policy);
        }
    }

    // Get policies expiring in the next 30 days
    public Set<Policy> getExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        Set<Policy> soonExpiring = new TreeSet<>();
        for (Policy policy : treeSetPolicies) {
            if (!policy.getExpiryDate().isAfter(threshold)) {
                soonExpiring.add(policy);
            }
        }
        return soonExpiring;
    }

    // Get policies of a specific coverage type
    public Set<Policy> getPoliciesByType(String coverageType) {
        Set<Policy> filteredPolicies = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                filteredPolicies.add(policy);
            }
        }
        return filteredPolicies;
    }

    // Identify duplicate policies by policy number
    public Set<String> findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (Policy policy : hashSetPolicies) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy.getPolicyNumber());
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();
        
        manager.addPolicy(new Policy("P001", "John Doe", LocalDate.now().plusDays(15), "Health", 1200.0));
        manager.addPolicy(new Policy("P002", "Jane Smith", LocalDate.now().plusDays(45), "Auto", 800.0));
        manager.addPolicy(new Policy("P003", "Alice Brown", LocalDate.now().plusDays(10), "Home", 1500.0));
        manager.addPolicy(new Policy("P004", "Bob White", LocalDate.now().plusDays(5), "Health", 1100.0));
        manager.addPolicy(new Policy("P001", "John Doe", LocalDate.now().plusDays(15), "Health", 1200.0)); // Duplicate
        
        System.out.println("All Policies (HashSet):");
        manager.displayPolicies(manager.hashSetPolicies);
        
        System.out.println("\nPolicies Expiring Soon:");
        manager.displayPolicies(manager.getExpiringSoon());
        
        System.out.println("\nHealth Insurance Policies:");
        manager.displayPolicies(manager.getPoliciesByType("Health"));
        
        System.out.println("\nDuplicate Policy Numbers:");
        System.out.println(manager.findDuplicatePolicies());
    }
}
