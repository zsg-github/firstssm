package com.ssm.controller;

import com.ssm.entity.Student;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("controller")
@Controller
public class StudentController {
    //控制器依赖于Service

    @Autowired
    private StudentService studentService;

    //public void setStudentService(StudentService studentService) {
    //    this.studentService = studentService;
   // }

    //@RequestMapping("queryStudentByNo/{stuno}")
    //public String queryStudentByNo(@PathVariable("stuno") Integer stuNo , Map<String,Object> map) {
       // Student student = studentService.queryStudentByNo(stuNo) ;
       // map.put("student", student) ; //把查询结果放到request请求域
      //  return "success" ;
  //  }
    @RequestMapping("queryStudentByNo/{stuno}")
    public ModelAndView queryStudentByNo(@PathVariable("stuno") Integer stuNo ) {
        String viewName = "success";
        ModelAndView mv = new ModelAndView(viewName);
        Student student = studentService.queryStudentByNo(stuNo) ;
        mv.addObject("student",student);
        return  mv;
    }
   // @RequestMapping("addStudent")
   // public String addStudent(Student student) {
      //  studentService.addStudent(student) ;
       // return "success" ;
   // }

    //
    @RequestMapping("queryAllStudent")
    public ModelAndView queryAllStudent() {
        String viewName = "success";
        ModelAndView mvs = new ModelAndView(viewName);
        List<Student> students = studentService.queryAllStudent();
        //System.out.println(students);
        mvs.addObject("students",students);
        return  mvs;
    }

    //跳转到输入页面为Get请求
    @RequestMapping(value = "/addstu",method = RequestMethod.GET)
    public String toInputJsp(Map<String, Object> map){
        //当添加modelAttrbute后需要在controller里面添加一个对应的bean，如下
        map.put("student",new Student());
        return "input";
    }
    //添加数据为Post请求
    @RequestMapping(value = "/addstu",method =RequestMethod.POST)
    public String addStudent(@Valid Student student, Errors result,
                             Map<String, Object> map) {
        System.out.println(student);
        if(result.getErrorCount()>0){
            System.out.println("出错了");
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getField()+":"+error.getDefaultMessage());
            }

            //若页面出错，则转向定制的页面
            return "input";

        }

        studentService.addStudent(student) ;
        //重定向操作：如果返回的字符串带forward:或redirect:前缀时，
        //springmvc 会对他们进行特殊处理：将forward：和redirect:当成指示符，
        //其后的数据作为URL来处理
        return "redirect:queryAllStudent" ;
    }

    //删除
    @RequestMapping(value = "stu/{stuNo}",method = RequestMethod.DELETE)
    public String deleteStudentByStuNo(@PathVariable("stuNo") Integer stuNo){
        studentService.deleteStudentByStuNo(stuNo);
        return "redirect:http://localhost:8888/firstssm/controller/queryAllStudent" ;
    }

    //修改
    @RequestMapping(value = "stu/{stuNo}",method = RequestMethod.GET)
    public String input(@PathVariable("stuNo") Integer stuNo,Map<String,Object> map){
        //表单回显
        map.put("student",studentService.queryStudentByNo(stuNo));
        return "input";
    }



    @ModelAttribute(value = "student")
    public void  getStudent(@RequestParam(value = "stuNO",required = false) Integer stuNo,
                            Map<String,Object> map){
        if(stuNo!=null){
            map.put("student",studentService.queryStudentByNo(stuNo));
        }

    }

    @RequestMapping(value = "addstu",method = RequestMethod.PUT)
    public String updateStudent(@Valid Student student){
        studentService.updateStudentByStuNO(student);
        System.out.println(student);
        return "redirect:http://localhost:8888/firstssm/controller/queryAllStudent" ;
    }

    //使属性失效
   // @InitBinder
    //public void initBinder(WebDataBinder binder){
//        binder.setDisallowedFields("stuName");
//    }

    @RequestMapping("/testFileUpload")
    public String fileUpload(@RequestParam("desc") String desc,
                             @RequestParam("file")MultipartFile file)throws Exception{
        System.out.println(desc);
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getInputStream());
        return "filesuccess";
    }

//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception ex){
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }
    @RequestMapping("/testException")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i){
        System.out.println(10/i);
        return "filesuccess";
    }

}
