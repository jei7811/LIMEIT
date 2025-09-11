FROM   almalinux

RUN dnf install -y httpd
RUN echo "LIMEIT" > /var/www/html/index.html

EXPOSE 80
CMD ["/usr/sbin/httpd","-D","FOREGROUND"]