package com.simon.second

import org.gradle.api.Plugin
import org.gradle.api.Project


public class Second implements Plugin<Project>{

    @Override
    void apply(Project project) {

        println("================")
        println("second plugin")
        println("================")


    }
}