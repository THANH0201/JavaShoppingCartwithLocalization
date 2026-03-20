FROM eclipse-temurin:21-jre

WORKDIR /app

RUN apt-get update && \
    apt-get install -y locales fonts-noto-cjk && \
    locale-gen ja_JP.UTF-8 && \
    update-locale LANG=ja_JP.UTF-8 && \
    rm -rf /var/lib/apt/lists/*

ENV LANG=ja_JP.UTF-8
ENV LANGUAGE=ja_JP:ja
ENV LC_ALL=ja_JP.UTF-8

COPY target/JavaShoppingCartwithLocalization-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

#FROM eclipse-temurin:21-jre
#
#WORKDIR /app
#
## Install GUI libraries
#RUN apt-get update && \
#    apt-get install -y locales && \
#    locale-gen ja_JP.UTF-8 && \
#    update-locale LANG=ja_JP.UTF-8 && \
#    apt-get install -y \
#        libx11-6 libxext6 libxrender1 libxtst6 libxi6 libgtk-3-0 mesa-utils wget unzip && \
#    rm -rf /var/lib/apt/lists/*
#
#ENV LANG=ja_JP.UTF-8
#ENV LANGUAGE=ja_JP:ja
#ENV LC_ALL=ja_JP.UTF-8
#
## Download and unzip JavaFX Linux SDK
#RUN mkdir -p /javafx-sdk \
#    && wget -O javafx.zip https://download2.gluonhq.com/openjfx/21.0.2/openjfx-21.0.2_linux-x64_bin-sdk.zip \
#    && unzip javafx.zip -d /javafx-sdk \
#    && mv /javafx-sdk/javafx-sdk-21.0.2/lib /javafx-sdk/lib \
#    && rm -rf /javafx-sdk/javafx-sdk-21.0.2 javafx.zip
#
## Copy your fat JAR
#  COPY target/JavaShoppingCartwithLocalization-1.0-SNAPSHOT.jar app.jar
# #COPY target/*.jar app.jar
## Set X11 display (Windows host with Xming/X11)
#ENV DISPLAY=host.docker.internal:0.0
#
## Run JavaFX app
#CMD ["java", "--module-path", "/javafx-sdk/lib", "--add-modules", "javafx.controls,javafx.fxml", "-jar", "app.jar"]
