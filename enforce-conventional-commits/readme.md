It is really important to have a clean git history, 
so having clear and well formated commits is a must.

This demo project showcases how to enforce conventional
commits along with Jira issues in between braces at the
start of your commit :

`[<JIRA-TICKET>] <type><(optional_scope)>: <description>`
- Example: `[PRJ-1252] feat(api): add authentication support`
- Example: `[PRJ-1242] feat: add commit-msg hooks`
- Example: `build: add new maven module`
- Example: `ci(mergeRequests): add sonar analysis`