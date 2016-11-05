# Example: Using basic scripts with Gradle

## Description
  This is a set of very simple scripts built with Gradle.

## Pre-requisites
  1. To have Gradle installed

## Checking existing tasks  
  Inside any folder run `gradle tasks` to see the tasks available to be run.

## Content

  1. Tasks
    - `cd 1_tasks`
    - Run `gradle hello goodBye`
      - Check in the console that the tasks executed are `:hello` and `:goodBye`

  2. Dependencies
    - `cd 2_dependencies`
    - Run `gradle goodBye`
      - Check in the console that the first executed task is `:hello` and the last is `:goodBye` (all other tasks run in between, due to their dependency to any task where the name starts with `day`)
    - Run `gradle third`
      - Check in the console that the first executed task is `:first`, followed by `:second` and the last is `:third` (task `third` has multiple dependencies)

  3. Interruptions
    - `cd 3_interruptions`
    - Run `gradle eclipse`
      - Check in the console that the task executed is `:eclipse` and it is shown as `SKIPPED` (internally it throws an exception)

  4. Plugins
    - `cd 4_plugins`
    - Run `gradle myPlugin`
      - Check in the console that the executed task is `:myPlugin`, which is implemented inside `PluginTest`

  5. Build
    - `cd 5_build`
    - Run `gradle task4`
      - Check in the console that the executed tasks are `:task1`, `:task2`, `:task3` and `:task4`
    - Run `gradle task4 -x task3`
      - Check in the console that the executed tasks are `:task1` and `:task4`
    - Run `gradle -b src/build.gradle subTask`
      - Check in the console that the executed task is `:subTask`, which is implemented in the file `src/build.gradle`

   6. Java Build
    - `cd 6_javaBuild`
    - Run `gradle build`
      - Check in the console that the executed a few tasks are executed, where one of them is `:build`
      - Check that a folder named `build` has been created
      - Check that in `build/libs` there is a JAR file
    - Run `java -jar build/lib/6_javaBuild`
      - Check in the console that the executed JAR writes `Running class Gradle from the JAR file.`

  7. Java Test
    - TBD

   8. Init task
     - `cd 6_init`
     - Run `gradle init --type java-library`
       - Check the content for created files `build.gradle` and `settings.gradle`
       - Check the created directory structure under `src` and the Java files in it
       - Check more information in the [documentation](https://docs.gradle.org/current/userguide/build_init_plugin.html)
