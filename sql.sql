use edu_sys;

#教师表
create table if not exists edu_sys.teachers
(
    t_id             varchar(11) primary key not null ,
    t_name           varchar(30)                                                   null,
    t_gender         enum ('男', '女')                                             null,
    t_birthday       date                                                          null,
    t_degree         enum ('本科', '硕士', '博士', '其他')                         null,
    t_password       varchar(30)                                                  null,
    t_telephone      varchar(11)                                                   null,
    t_politic        enum ('党员', '共青团员', '入党积极分子', '其他党派', '群众') null,
    t_admission_year varchar(20)                                                   null,
    t_college        int                                                       null,
    t_work_time      varchar(50)                                                   null
);

/*插入部分教师信息*/
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values('1001', '张三', '男', '1980-01-01', '博士', '123456', '13800138000', '党员', '2010', 1, '教授');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values('1002', '李四', '女', '1985-02-02', '硕士', '123456', '13800138001', '共青团员', '2012', 1, '副教授');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values('1003', '王五', '男', '1988-03-03', '本科', '123456', '13800138002', '入党积极分子', '2014', 2, '讲师');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values('1004', '赵六', '女', '1990-04-04', '博士', '123456', '13800138003', '其他党派', '2016', 2, '教授');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values ('1005', '钱七', '男', '1992-05-05', '硕士', '123456', '13800138004', '群众', '2018', 3, '副教授');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values ('1006', '孙八', '女', '1994-06-06', '本科', '123456', '13800138005', '党员', '2020', 3, '讲师');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values ('1007', '周九', '男', '1996-07-07', '博士', '123456', '13800138006', '共青团员', '2022', 4, '教授');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values ('1008', '吴十', '女', '1998-08-08', '硕士', '123456', '13800138007', '入党积极分子', '2024', 4, '副教授');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values ('1009', '郑十一', '男', '2000-09-09', '本科', '123456', '13800138008', '其他党派', '2026', 5, '讲师');
insert into edu_sys.teachers (t_id, t_name, t_gender, t_birthday, t_degree, t_password, t_telephone, t_politic, t_admission_year, t_college, t_work_time)
values ('1010', '王十二', '女', '2002-10-10', '博士', '123456', '13800138009', '群众', '2028', 5, '教授');



#管理员表
create table if not exists edu_sys.admin
(
    t_id       int
        primary key,
    foreign key (t_id) references edu_sys.teachers (t_id)
);

/*插入部分管理员数据*/
insert into edu_sys.admin (t_id)values (1001);
insert into edu_sys.admin (t_id)values (1002);
insert into edu_sys.admin (t_id)values (1003);


#学生表
create table if not exists edu_sys.students
(
    s_id             varchar(11) primary key not null,
    s_name           varchar(30)                                                   null,
    s_gender         enum ('男', '女')                                             not null,
    s_birthday       date                                                          null,
    s_graduate       varchar(30)                                                   null,
    s_password       varchar(50)                                                   null,
    s_telephone      varchar(11)                                                   null,
    s_politic        enum ('党员', '共青团员', '入党积极分子', '其他党派', '群众') null,
    s_admission_year varchar(20)                                                   null,
    s_college        int                                                      null,
    s_major          varchar(20)                                                   null,
    s_class          varchar(20)                                                   null,
    s_status         enum ('在校', '休学', '退学', '毕业')                         null
);

/*插入部分学生信息数据*/
insert into edu_sys.students (s_id, s_name, s_gender, s_birthday, s_graduate, s_password, s_telephone, s_politic, s_admission_year, s_college, s_major, s_class, s_status)
values ('20210001', '张三', '男', '2000-01-01', '南方第一中学', '123456', '13800138000', '党员', '2021', 1, '计算机科学与技术', '1班', '在校'),
       ('20210002', '李四', '女', '2001-02-02', '北方第一中学', '123456', '13800138001', '共青团员', '2021', 1, '计算机科学与技术', '1班', '在校'),
       ('20210003', '王五', '男', '2002-03-03', '西方第一中学', '123456', '13800138002', '入党积极分子', '2021', 1, '计算机科学与技术', '1班', '在校'),
       ('20210004', '赵六', '女', '2003-04-04', '东方第一中学', '123456', '13800138003', '其他党派', '2021', 1, '计算机科学与技术', '1班', '在校');
insert into edu_sys.students (s_id, s_name, s_gender, s_birthday, s_graduate, s_password, s_telephone, s_politic, s_admission_year, s_college, s_major, s_class, s_status)
values ('20210005', '钱七', '男', '2004-05-05', '东方第一中学', '123456', '13800138004', '群众', '2021', 2, '软件工程', '2班', '在校');
insert into edu_sys.students (s_id, s_name, s_gender, s_birthday, s_graduate, s_password, s_telephone, s_politic, s_admission_year, s_college, s_major, s_class, s_status)
values ('20210006', '孙八', '女', '2005-06-06', '西方第一中学', '123456', '13800138005', '党员', '2021', 2, '软件工程', '2班', '在校'),
       ('20210007', '周九', '男', '2006-07-07', '西方第一中学', '123456', '13800138006', '共青团员', '2021', 2, '软件工程', '2班', '在校');
insert into edu_sys.students (s_id, s_name, s_gender, s_birthday, s_graduate, s_password, s_telephone, s_politic, s_admission_year, s_college, s_major, s_class, s_status)
values ('20210008', '吴十', '女', '2007-08-08', '东方第一中学', '123456', '13800138007', '入党积极分子', '2021', 3, '网络工程', '3班', '在校'),
       ('20210009', '郑十一', '男', '2008-09-09', '西方第一中学', '123456', '13800138008', '其他党派', '2021', 3, '网络工程', '3班', '在校'),
       ('20210010', '王十二', '女', '2002-10-10', '东方第一中学', '123456', '13800138009', '群众', '2021', 3, '网络工程', '3班', '在校');


#学院表
create table if not exists edu_sys.college
(
    college_id   int auto_increment
        primary key not null ,
    college_name varchar(20) null,
    college_dean varchar(30) null
);

/*插入部分学院信息*/
insert into edu_sys.college (college_name, college_dean)values ('计算机学院', '张三'),
       ('软件学院', '李四'),
       ('网络工程学院', '王五');
insert into edu_sys.college (college_name, college_dean)values ('外国语学院', '赵六'),
       ('艺术学院', '钱七'),
       ('体育学院', '孙八');
insert into edu_sys.college (college_name, college_dean)values ('经济学院', '周九'),
       ('管理学院', '吴十');

#班级表
create table if not exists edu_sys.class
(
    class_id      int auto_increment
        primary key not null ,
    class_name    varchar(30) null,
    college_id    int         null,
    class_teacher varchar(11) null,
    foreign key (college_id) references edu_sys.college (college_id),
    foreign key (class_teacher) references edu_sys.teachers (t_id)
);

/*插入部分班级信息*/
insert into edu_sys.class (class_name, college_id, class_teacher)
values('21计算机本科1班', 1, '1001');
insert into edu_sys.class (class_name, college_id, class_teacher)
values('21计算机本科2班', 2, '1002');
insert into edu_sys.class (class_name, college_id, class_teacher)
values('21计算机本科3班', 4, '1003');
insert into edu_sys.class (class_name, college_id, class_teacher)
values('21计算机本科4班', 7, '1004');
insert into edu_sys.class (class_name, college_id, class_teacher)
values('21计算机本科5班', 1, '1005');
insert into edu_sys.class (class_name, college_id, class_teacher)
values('21计算机本科6班', 2, '1006');
insert into edu_sys.class (class_name, college_id, class_teacher)
values('21计算机本科7班',3, '1007');

#课程表
create table if not exists edu_sys.course
(
    c_id       int auto_increment
        primary key not null ,
    c_name     varchar(30) null,
    c_teacher_id  varchar(30)  null,
    c_location varchar(20) null,
    c_credit   int         null,
    c_hours    int         null,
    c_type     varchar(10) null,
    foreign key (c_teacher_id) references edu_sys.teachers (t_id)
);

/*插入部分课表数据*/
insert into edu_sys.course (c_name, c_teacher_id, c_location, c_credit, c_hours, c_type)
values ('高等数学', '1001', 'A101', 4, 48, '必修'),
       ('线性代数', '1002', 'A102', 4, 48, '必修'),
       ('离散数学', '1003', 'A103', 4, 48, '必修'),
       ('大学英语', '1004', 'A104', 4, 48, '必修'),
       ('大学物理', '1005', 'A105', 4, 48, '必修'),
       ('计算机组成原理', '1006', 'A106', 4, 48, '必修'),
       ('数据结构', '1007', 'A107', 4, 48, '必修');
insert into edu_sys.course (c_name, c_teacher_id, c_location, c_credit, c_hours, c_type)
values ('计算机网络', '1008', 'A108', 4, 48, '必修'),
       ('操作系统', '1009', 'A109', 4, 48, '必修'),
       ('编译原理', '1010', 'A110', 4, 48, '必修'),
       ('数据库原理', '1008', 'A111', 4, 48, '必修'),
       ('软件工程', '1009', 'A112', 4, 48, '必修'),
       ('人工智能', '1010', 'A113', 4, 48, '必修'),
       ('计算机图形学', '1010', 'A114', 4, 48, '必修');


#选课表
create table if not exists edu_sys.selection
(
    s_id varchar(11) not null
        primary key,
    c_id int         null,
    foreign key (c_id) references edu_sys.course (c_id),
    foreign key (s_id) references edu_sys.students (s_id)
);

/*插入部分选课数据*/
insert into edu_sys.selection (s_id, c_id)values ('20210001', 1),
       ('20210002', 2),
       ('20210003', 3),
       ('20210004', 4),
       ('20210005', 5),
       ('20210006', 6),
       ('20210007', 7);
insert into edu_sys.selection (s_id, c_id)values ('20210008', 8),
       ('20210009', 9),
       ('20210010', 10);

#上课表
create table if not exists edu_sys.teach
(
    t_id varchar(11) null,
    c_id int         null,
    foreign key (t_id) references edu_sys.teachers (t_id),
    foreign key (c_id) references edu_sys.course (c_id)
);

/*插入部分上课数据*/
insert into edu_sys.teach (t_id, c_id)values ('1001', 1),
       ('1002', 2),
       ('1003', 3),
       ('1004', 4),
       ('1005', 5),
       ('1006', 6),
       ('1007', 7);
insert into edu_sys.teach (t_id, c_id)values ('1008', 8),
       ('1009', 9),
       ('1010', 10);

#成绩表
create table if not exists edu_sys.score
(
    s_id       varchar(11) null,
    c_id       int         null,
    score         int         null,
    average_score int         null,
    exam_score    int         null,
    foreign key (s_id) references edu_sys.selection (s_id),
    foreign key (c_id) references edu_sys.selection (c_id)
);

/*插入部分成绩信息*/
insert into edu_sys.score (s_id, c_id, score, average_score, exam_score)values ('20210001', 1, 90, 85, 90),
       ('20210002', 2, 85, 80, 85),
       ('20210003', 3, 95, 90, 95),
       ('20210004', 4, 80, 75, 80),
       ('20210005', 5, 75, 70, 75),
       ('20210006', 6, 70, 65, 70),
       ('20210007', 7, 65, 60, 65);
insert into edu_sys.score (s_id, c_id, score, average_score, exam_score)values ('20210008', 8, 60, 55, 60),
       ('20210009', 9, 55, 50, 55),
       ('20210010', 10, 50, 45, 50);