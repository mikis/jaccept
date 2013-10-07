package org.jaccept;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.reporting.MavenReport;
import org.apache.maven.reporting.MavenReportException;
import org.codehaus.doxia.sink.Sink;
import org.jaccept.testreport.ReportGenerator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

/**
 * @goal generate-report
 * @description Facade generator for data entities
 */
public class MavenJacceptReport extends AbstractMojo implements MavenReport {
    /**
     * The output directory for the report.
     *
     * @parameter default-value="${project.reporting.outputDirectory}/jaccept"
     * @required
     */
    private File outputDirectory;

    /**
     * <i>Maven Internal</i>: Project to interact with.
     *
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    public void execute() throws MojoExecutionException {
        File f = outputDirectory;

        if (!f.exists()) {
            f.mkdirs();
        }

        File touch = new File(f, "touch.txt");

        FileWriter w = null;
        try {
            w = new FileWriter(touch);
            w.write("touch.txt");
        } catch (IOException e) {
            throw new MojoExecutionException("Error creating file " + touch, e);
        } finally {
            if (w != null) {
                try {
                    w.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public boolean canGenerateReport() {
        return true;
    }

    public void generate(Sink arg0, Locale arg1) throws MavenReportException {
        // TODO Auto-generated method stub

    }

    public String getCategoryName() {
        return MavenReport.CATEGORY_PROJECT_REPORTS;
    }

    /**
     * @see org.apache.maven.reporting.MavenReport#getDescription(java.util.Locale)
     */
    public String getDescription(Locale locale) {
        if (locale.equals(Locale.ENGLISH)) return "JAccept report description";
        else return "JAccept report description";
    }

    /**
     * @see org.apache.maven.reporting.MavenReport#getName(java.util.Locale)
     */
    public String getName(Locale locale) {
        if (locale == Locale.ENGLISH) return "JAccept output name";
        else return "JAccept output name";
    }

    public String getOutputName() {
        return "jaccept-testreport.html";
    }

    /**
     * @see org.apache.maven.reporting.AbstractMavenReport#getOutputDirectory()
     */
    protected String getOutputDirectory() {
        return outputDirectory.getAbsolutePath();
    }

    public File getReportOutputDirectory() {
        return outputDirectory;
    }

    public boolean isExternalReport() {
        return true;
    }

    public void setReportOutputDirectory(File testreportDirectory) {
        this.outputDirectory = testreportDirectory;
        ReportGenerator.setTestreportFile(new File(testreportDirectory, "jaccept-testreport.html"));
    }
}
