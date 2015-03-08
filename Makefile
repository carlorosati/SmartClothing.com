OUTDIR=bin
SRCDIR=src
PKGNAME=gui

# How to run:
# java -classpath $(OUTDIR) package.Classname

compile:
	javac -d $(OUTDIR) -cp $(OUTDIR) -sourcepath $(SRCDIR) src/$(PKGNAME)/*.java

run: compile
	java -cp $(OUTDIR) $(PKGNAME).Main

clean:
	rm -rf $(OUTDIR)/*