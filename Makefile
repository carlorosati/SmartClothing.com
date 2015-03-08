OUTDIR=bin/
SRCDIR=src/
PKGNAME=gui

# How to run:
# java -classpath $(OUTDIR) package.Classname

default:
	javac -d $(OUTDIR) -cp $(OUTDIR) -sourcepath $(SRCDIR) src/$(PKGNAME)/*.java

clean:
	rm -rf bin/*