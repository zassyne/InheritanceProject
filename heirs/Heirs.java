package inheritanceproject.heirs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yassine
 */
public final class Heirs {
    
    ArrayList<Heir> m_heirs;
    // Collection of people that may inherit the rest.
    Map<String, Boolean> m_heirs_inherits_rest;
    
    // Collection of people that may not inherit.
    Map<String, Boolean> m_heirs_no_inheritance;
    
    public Heirs() {
        init();

    }
    
    public void init() {
        m_heirs = new ArrayList<>();
        m_heirs_inherits_rest = new HashMap<>();
        m_heirs_no_inheritance= new HashMap<>();
        
        
        m_heirs_inherits_rest.put("father", false);
        m_heirs_inherits_rest.put("mother", false);
        m_heirs_inherits_rest.put("son", false);
        m_heirs_inherits_rest.put("daugther", false);
        
        m_heirs_no_inheritance.put("grandfather", false);
        m_heirs_no_inheritance.put("grandmother", false);
        m_heirs_no_inheritance.put("grandson", false);

        
    }
    public boolean inheritsTheRest(Heir heir) {
        String degree = heir.getDegree();
        return m_heirs_inherits_rest.get(degree);
    }
    public void setInheritsTheRest(Heir heir) {
        m_heirs_inherits_rest.put(heir.getDegree(), true);
    }
    public void simplifyQuotas() {
        m_heirs.stream().forEach((heir) -> {
            heir.getQuota().simplifiy();
        });
        
    }
    public boolean isThereBranches() {
        
        String son = "son";
        String daugther = "daugther";
        
        return m_heirs.stream().anyMatch((heir) -> (heir.getDegree().equals(son) || heir.getDegree().equals(daugther)));
    }
    public boolean isThereSomeoneExcept(Heir heir) {
        
        return m_heirs.stream().anyMatch((h) -> (h != heir && h != null)); 
    }
    public Heir getHeir(int index) {
        return m_heirs.get(index);
    }
    public int getSize() {
        return m_heirs.size();
    }
    public void addHeir(String degree, int quantity) {
        
        m_heirs.add(new Heir(degree, quantity));
    }
    
    public Heir getHeir(String degree) {
        
        for(Heir heir : m_heirs) {
            if(heir.getDegree().equalsIgnoreCase(degree)){
                return heir;
            }
        }
        return null ;
    }
    public void resetRemainingQuota() {
        Heir.resetRemainingQuota();
    }
    public boolean maleBranchExists() {
        return m_heirs.stream().anyMatch((heir) -> (heir.getDegree().equalsIgnoreCase("son")));
    }
    public boolean branchExists() {
        return m_heirs.stream().anyMatch((heir) -> (heir.getDegree().equalsIgnoreCase("son") || heir.getDegree().equalsIgnoreCase("daughter")));
    }
    
    public void clear() {
        m_heirs.clear();
    }
}