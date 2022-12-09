package factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class AnimalFactoryBean implements FactoryBean<Animal> {

    private boolean isCat;

    public AnimalFactoryBean(boolean isCat) {
        this.isCat = isCat;
    }

    @Override
    public Animal getObject() throws Exception {
        return this.isCat ? new Cat() : new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }

    public boolean isCat() {
        return isCat;
    }

    public void setCat(boolean cat) {
        isCat = cat;
    }
}
