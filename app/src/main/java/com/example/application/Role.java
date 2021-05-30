package com.example.application;

public  class Role {

    /*玩家的昵称*/
    public String name;
    /*角色的血量*/
    public int HP;
    /*角色的防御力*/
    public int defend;
    /*角色的攻击值*/
    public int atk;
    /*角色的等级*/
    public int grade;
    /*角色的经验值*/
    public int exe;
    /*玩家的性别*/
    public int sex;

    /*一个游戏角色应有的属性*/
    public Role(String name,int hp,int defend,int atk,int grade,int exe,int sex){
        this.name = name;
        this.HP = hp;
        this.defend = defend;
        this.atk = atk;
        this.grade = grade;
        this.exe = exe;
        this.sex = sex;
    }


    /*此方法将设定角色的昵称*/
    public void setName(String name) {
        this.name = name;
    }

    /*此方法将设定角色的性别*/
    public void setSex(int sex) {
        this.sex = sex;
    }

    /*此方法将设定角色的等级*/
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /*此方法将设定角色的经验值*/
    public void setExe(int exe) {
        this.exe += exe;
    }

    /*此方法将设定角色的血量值*/
    public void setHP(int HP) {
        this.HP += HP;
    }

    /*此方法将设定角色的攻击值*/
    public void setAtk(int atk) {
        this.atk += atk;
    }

    /*此方法将设定角色的防御值*/
    public void setDefend(int defend) {
        this.defend += defend;
    }



    /*此方法将返回角色的攻击值*/
    public int getAtk() {
        return atk;
    }

    /*此方法将返回角色的血量值*/
    public int getHP() {
        return HP;
    }

    /*此方法将返回角色的昵称*/
    public String getName() {
        return name;
    }

    /*此方法将返回角色的性别值*/
    public int getSex() {
        return sex;
    }

    /*此方法将返回角色的防御值*/
    public int getDefend() {
        return defend;
    }

    /*此方法将返回角色的等级*/
    public int getGrade() {
        return grade;
    }

    /*此方法将返回角色的经验值*/
    public int getExe() {
        return exe;
    }

}
