package designpatterns.proxy;

/**
 * @Auther: lick
 * @Description:
 * @Date: 2018/10/18 18:43
 */
public class ClassroomOption implements IClassroomOption{
    @Override
    public void addClassroom(String roomName) {
        System.out.println("have add classroom" + roomName);
    }

    @Override
    public void deleteClassroom(String roomName) {
        System.out.println("have delete classroom" + roomName);
    }

    @Override
    public void enterClassroom(String roomName) {
        System.out.println("success enter classroom" + roomName);
    }
}
