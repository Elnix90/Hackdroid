./gradlew kobwebStart -PkobwebEnv=DEV -PkobwebRunLayout=FULLSTACK -t
cd site
kobweb stop
kobweb run