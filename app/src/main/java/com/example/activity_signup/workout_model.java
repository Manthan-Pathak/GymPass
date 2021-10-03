package com.example.activity_signup;

class workout_model {
    String name,repet;

    workout_model()
    {

    }

    public workout_model(String name, String rep) {
        this.name = name;
        this.repet = rep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepet() {
        return repet;
    }

    public void setRepet(String rep) {
        this.repet = repet;
    }
}
