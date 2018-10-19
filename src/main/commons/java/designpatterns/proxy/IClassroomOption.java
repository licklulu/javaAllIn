package designpatterns.proxy;

/**
 * @Auther: licklulu
 * @Description:
 * @Date: 2018/10/18 18:41
 */
public interface IClassroomOption {
    void addClassroom(String roomName);
    void deleteClassroom(String roomName);
    void enterClassroom(String roomName);
}
