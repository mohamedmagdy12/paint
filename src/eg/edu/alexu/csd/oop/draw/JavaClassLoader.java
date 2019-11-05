package eg.edu.alexu.csd.oop.draw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.ClassLoader;


public class JavaClassLoader extends ClassLoader {
    ClassLoader x=new ClassLoader() {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name);
        }

        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            return super.loadClass(name, resolve);
        }
    };
    public void invokeClassMethod(String classBinName, String methodName){

        try {

            // Create a new JavaClassLoader
            ClassLoader classLoader = this.getClass().getClassLoader();

            // Load the target class using its binary name
            Class loadedMyClass = classLoader.loadClass(classBinName);

            System.out.println("Loaded class name: " + loadedMyClass.getName());

            // Create a new instance from the loaded class
            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();

            // Getting the target method from the loaded class and invoke it using its name
            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
