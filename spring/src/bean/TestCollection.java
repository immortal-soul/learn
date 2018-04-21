package bean;


import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestCollection {
    private Set set;
    private List list;
    private Map map;
    private Properties prop;

    public Set getSet() {
        return set;
    }

    public List getList() {
        return list;
    }

    public Map getMap() {
        return map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public void printAll(){
        System.out.println("Set : " + set.toString());
        System.out.println("List : " + list.toString());
        System.out.println("Map : " + map.toString());
        System.out.println("Prop : " + prop.toString());
    }
}
