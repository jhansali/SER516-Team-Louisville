package TaskDefectDensity;

import com.fasterxml.jackson.databind.JsonNode;

import utils.Tasks;

import java.util.List;
import java.util.ArrayList;

public class TaskDefectDensity{

    private List<JsonNode> unfinishedTasks = new ArrayList<>();
    private List<JsonNode> totalTasks = new ArrayList<>();
    private int numberOfDeletedTasks;
    private double taskDefectDensity;
    public double getTaskDefectDensity() {
        return this.taskDefectDensity;
    }

    public int getNumberOfTotalTasks(){
        return this.totalTasks.size();
    }

    public int getNumberOfUnfinishedTasks(){
        return this.unfinishedTasks.size();
    }

    public int getNumberOfDeletedTasks(){
        return this.numberOfDeletedTasks;
    }

    public TaskDefectDensity(String authToken, String TAIGA_API_ENDPOINT, int projectId, String sprint ){
        this.totalTasks = Tasks.getAllTasks(projectId, authToken, TAIGA_API_ENDPOINT, sprint);
        this.unfinishedTasks = Tasks.getUnfinishedTasks(projectId, authToken, TAIGA_API_ENDPOINT, sprint);
        this.numberOfDeletedTasks= Tasks.getDeletedTasks(projectId, authToken, TAIGA_API_ENDPOINT, sprint);
        this.taskDefectDensity = ((double)( this.unfinishedTasks.size() + this.numberOfDeletedTasks )/this.totalTasks.size()) * 100;
        System.out.println("TDD" + this.taskDefectDensity);
    }
}