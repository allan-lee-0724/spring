# This bash script will be used to create my sports docker image
# I will use this script instead of manually entering in commands
# So I don't accidentally make a spelling mistake

docker build -t allanlee0724/sports:file .
docker push allanlee0724/sports:file