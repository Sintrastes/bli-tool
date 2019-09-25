
# NOTE: I should be getting this from bli-tool.sbt.
# I also need to make sure wherever this shows up in my
# code, it is being propogated from the same place.
VERSION = 1.0

default: install

install: 
	 sbt assembly
	 chmod +x target/scala-2.12/bli-cli-assembly-1.0.jar 
	 cp target/scala-2.12/bli-cli-assembly-1.0.jar ~/.local/bin/bli