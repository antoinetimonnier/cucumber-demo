#!/bin/sh

# Le secret token est récupérer depuis Cucumber studio dans Project Settings > Secret token
SECRET_TOKEN=40074803351239285093254358173139769397450455822745809670
# L'id du test run peut être récupérée directement dans cucumber studio en allant sur le test run concerné et en récuépérant son id dans l'url
TESTRUN_IC_ID=379275

if [ ! -d "target/cucumber" ]; then
	mkdir target/cucumber
fi

curl "https://export.cucumber.io/download?token=$SECRET_TOKEN&lang=cucumber-java&test_run=$TESTRUN_IC_ID&filter_on=&filter_on_value=&filter_on_status=&only%5B%5D=features&with_folders=on" --compressed -o target/cucumber/cucumberExport.zip
if [ -f "target/cucumber/cucumberExport.zip" ]; then
	rm -rf src/test/resources/features
	unzip target/cucumber/cucumberExport.zip features/* -d src/test/resources/
	rm target/cucumber/cucumberExport.zip
fi
