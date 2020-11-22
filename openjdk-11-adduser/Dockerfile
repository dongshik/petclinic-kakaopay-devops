FROM openjdk:11-jdk

ARG user=apprun
ARG group=apprun
ARG uid=1000
ARG gid=1000

RUN groupadd -g ${gid} ${group}
RUN useradd -d "/home/${user}" -u ${uid} -g ${gid} -m -s /bin/bash ${user}
