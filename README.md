Inside any folder run `gradle tasks` to see the tasks available to be run.

1. Tasks
   - Run `gradle hello goodBye`
   - Check in the console that it runs tasks `:hello` and `:goodBye`

2. Dependencies
    - Run `gradle goodBye`
    - Check in the console that the first task to run is `:hello` and the last is `:goodBye` (all other tasks run in between, due to their dependency to any task where the name starts with `day`)

3. Interruptions
    - Run `gradle eclipse`
    - See the console that the task is shown as `SKIPPED`

4.
