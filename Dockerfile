FROM markhobson/maven-chrome:jdk-16

#RUN apt-get update; apt-get clean
#
## Add a user for running applications.
#RUN useradd apps
#RUN mkdir -p /home/apps && chown apps:apps /home/apps
#
## Install x11vnc.
#RUN apt-get install -y x11vnc
#
## Install xvfb.
#RUN apt-get install -y xvfb
#
## Install fluxbox.
#RUN apt-get install -y fluxbox
#
## Install wget.
#RUN apt-get install -y wget
#
## Install wmctrl.
#RUN apt-get install -y wmctrl
#
## Set the Chrome repo.
#RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
#    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list
#
## Install Chrome.
#RUN apt-get update && apt-get -y install google-chrome-stable

ENV APP_PORT=9090
ENV DRIVER=chromedriver_linux64/chromedriver

ADD src/main/resources/chromedriver_linux64/chromedriver chromedriver_linux64/chromedriver
ADD target/futures-1.0.jar futures-1.0.jar

EXPOSE ${APP_PORT}

ENTRYPOINT ["java","-jar","futures-1.0.jar"]