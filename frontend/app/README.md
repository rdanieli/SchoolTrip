Instalar o node.js com o gerenciador de pacotes NPM

- instalar:
	linha de comando: npm install -g grunt
	linha de comando: npm intall -g bower
	linha de comando: npm install -g cordova
		- instalar o Android SDK com o SDK manager: Após instalar e configurar as variável de ambiente rodar:
		Windows linha de comando:
			set ANDROID_HOME=C:\ installation location \android-sdk

			set PATH=%PATH%;%ANDROID_HOME%\tools;%ANDROID_HOME%\platform-tools
		- grunt platform:add:android
		- servidor: grunt serve --consolelogs

	linha de comando: bower install