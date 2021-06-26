package com.xuhao.handler;

import com.xuhao.entity.Student;
import com.xuhao.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController{
    private IStudentService service;

    @Autowired
    @Qualifier("studentService")
    public void setService(IStudentService service) {
        this.service = service;
    }

    /*添加学生信息*/
    @RequestMapping("/addStudent.do")
    public ModelAndView doAddStudent(Integer id, String name, Integer age) {

        // 创建视图
        ModelAndView modelAndView = new ModelAndView();

        // 获取参数组装为Student对象
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);

        // 插入表
        int nums = service.addStudent(student);

        String hint = nums>0?"添加【"+student.getName()+"】成功":"添加失败";
        modelAndView.addObject("hint", hint);

        // 结束后跳转结果页面
        modelAndView.setViewName("hint");

        return modelAndView;
    }

    /*删除学生信息*/
    @RequestMapping("/removeStudent.do")
    public String doRemoveStudent(Integer id, Model model) {
        // 删除表
        int nums = service.removeStudentById(id);

        String hint = nums>0?"删除id为【"+id+"】的学生成功":"删除失败";
        model.addAttribute("hint", hint);

        // 结束后跳转结果页面
        return "hint";
    }

    /*更新学生信息*/
    @RequestMapping("/modifyStudent.do")
    public ModelAndView domodifyStudent(Integer id, String name, Integer age) {

        // 创建视图
        ModelAndView modelAndView = new ModelAndView();

        // 获取参数组装为Student对象
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);

        // 更新数据库
        int nums = service.modifyStudent(student);
        String hint = nums>0?"更新【"+student.getName()+"】成功":"更新失败";
        modelAndView.addObject("hint", hint);

        // 结束后跳转结果页面
        modelAndView.setViewName("hint");

        return modelAndView;
    }

    /*ID查询学生信息*/
    @RequestMapping("/selectStudent.do")
    public ModelAndView doSelectStudent(Integer id) {

        // 创建视图
        ModelAndView modelAndView = new ModelAndView();

        // 查询表
        Student student = service.findStudentById(id);
        modelAndView.addObject("hint", student);

        // 结束后跳转结果页面
        modelAndView.setViewName("hint");

        return modelAndView;
    }

    /*ajax实现查询所有学生*/
    @RequestMapping("/queryAllStudents.do")
    @ResponseBody
    public List<Student> doQueryAllStudents() {
        List<Student> studentList = service.findAllStudents();
        return studentList;
    }
}
