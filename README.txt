The workspace is configured to use the JAR files already inside the repository folder. Unfortunately, Eclipse/STS uses an absolute path to the repository folder (not a relative one). Thus, you'll need to change the path depending on where you copy the folder.

Given that ${INSTALL_DIR} is the folder in which you copied this, you'll need to edit the following files:

1. settings.xml
2. workspace/.metadata/.plugins/org.eclipse.core.runtime/.settings/org.eclipse.m2e.core.prefs

In the "settings.xml" file, find the <localRepository> element, and modify it to:

	<localRepository>${INSTALL_DIR}/web-spring-training/repository</localRepository>

where ${INSTALL_DIR} is the folder in which you installed.

	E.g. (for Windows) C:/Users/user-name/Desktop/web-spring-training/repository

	E.g. (for *nix) /Users/user-name/Desktop/web-spring-training/repository

In the "org.eclipse.m2e.core.prefs" file, modify the "eclipse.m2.userSettingsFile" value to:

	${INSTALL_DIR}/web-spring-training/settings.xml

where ${INSTALL_DIR} is the folder in which you installed.

	E.g. (for Windows) C:/Users/user-name/Desktop/web-spring-training/settings.xml

	E.g. (for *nix) /Users/user-name/Desktop/web-spring-training/settings.xml

Afer completing the above changes, save your file changes, and open Eclipse/STS.

Open (or switch to) "${INSTALL_DIR}/web-spring-training/workspace" when prompted to load a workspace.

After Eclipse/STS launches, choose "File > Import...", select "Existing Maven projects...". In the dialog, browse to "${INSTALL_DIR}/web-spring-training/workspace". Select all the projects. Click "Finish". It will take a few minutes to import and compile.

Enjoy learning!
